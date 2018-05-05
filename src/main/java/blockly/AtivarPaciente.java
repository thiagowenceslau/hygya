package blockly;

import cronapi.*;
import cronapi.rest.security.CronappSecurity;
import java.util.concurrent.Callable;

@CronapiMetaData(type = "blockly")
@CronappSecurity
public class AtivarPaciente {

	public static final int TIMEOUT = 300;

	/**
	 *
	 * @param dados
	 * @return Var
	 */
	// AtivarPaciente
	public static Var ativarPaciente(Var dados) throws Exception {
		return new Callable<Var>() {

			private Var ativo = Var.VAR_NULL;
			private Var login = Var.VAR_NULL;
			private Var usuarioId = Var.VAR_NULL;
			private Var usuario = Var.VAR_NULL;

			public Var call() throws Exception {
				login = cronapi.util.Operations.getCurrentUserName();
				usuario = cronapi.database.Operations.query(Var.valueOf("app.entity.User"),
						Var.valueOf("select u from User u where u.login = :login"), Var.valueOf("login", login));
				usuarioId = cronapi.database.Operations.getField(usuario, Var.valueOf("this[0].id"));
				cronapi.database.Operations.execute(Var.valueOf("app.entity.Paciente"),
						Var.valueOf(
								"update Paciente set agenteAutorizador = :agenteAutorizador, ativo = :ativo where id = :id"),
						Var.valueOf("agenteAutorizador", usuarioId), Var.valueOf("ativo", Var.valueOf("Sim")),
						Var.valueOf("id", dados));
				cronapi.util.Operations.callClientFunction(Var.valueOf("cronapi.screen.notify"), Var.valueOf("success"),
						Var.valueOf("Paciente Ativado!"));
				cronapi.util.Operations.callClientFunction(Var.valueOf("cronapi.screen.hideModal"),
						Var.valueOf("modalPesquisarPaciente"));
				return Var.VAR_NULL;
			}
		}.call();
	}

	/**
	 */
	// Descreva esta função...
	public static void validar() throws Exception {
		new Callable<Var>() {

			private Var login = Var.VAR_NULL;
			private Var agente = Var.VAR_NULL;
			private Var usuarioId = Var.VAR_NULL;

			public Var call() throws Exception {
				login = cronapi.util.Operations.getCurrentUserName();
				agente = cronapi.database.Operations.query(Var.valueOf("app.entity.Agente"),
						Var.valueOf("select a from Agente a where a.user.login = :userLogin"),
						Var.valueOf("userLogin", login));
				usuarioId = cronapi.database.Operations.getField(agente, Var.valueOf("this[0].user.id"));
				if (Var.valueOf(!cronapi.database.Operations.getField(agente, Var.valueOf("this[0].ativo"))
						.equals(Var.valueOf("Sim"))).getObjectAsBoolean()) {
					cronapi.util.Operations.callClientFunction(Var.valueOf("cronapi.screen.hideComponent"),
							Var.valueOf("crn-button-ativar"));
				}
				return Var.VAR_NULL;
			}
		}.call();
	}

	/**
	 *
	 * @param valida
	 */
	// Descreva esta função...
	public static void validarPaciente(Var valida) throws Exception {
		new Callable<Var>() {

			private Var ativo = Var.VAR_NULL;

			public Var call() throws Exception {
				ativo = cronapi.object.Operations.getObjectField(valida, Var.valueOf("ativo"));
				if (Var.valueOf(ativo.equals(Var.valueOf("Sim"))).getObjectAsBoolean()) {
					cronapi.util.Operations.callClientFunction(Var.valueOf("cronapi.screen.hideComponent"),
							Var.valueOf("crn-button-ativar"));
				}
				return Var.VAR_NULL;
			}
		}.call();
	}

}
