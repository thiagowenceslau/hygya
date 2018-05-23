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

			private Var login = Var.VAR_NULL;
			private Var usuario = Var.VAR_NULL;
			private Var usuarioId = Var.VAR_NULL;

			public Var call() throws Exception {
				login = cronapi.util.Operations.getCurrentUserName();
				usuario = cronapi.database.Operations.query(Var.valueOf("app.entity.User"),
						Var.valueOf("select u from User u where u.login = :login"), Var.valueOf("login", login));
				usuarioId = cronapi.database.Operations.getField(usuario, Var.valueOf("this[0].id"));
				cronapi.database.Operations.execute(Var.valueOf("app.entity.Paciente"),
						Var.valueOf(
								"update Paciente set agenteAutorizador = :agenteAutorizador, ativo = :ativo, dataAtivacao = :dataAtivacao where id = :id"),
						Var.valueOf("agenteAutorizador", usuarioId), Var.valueOf("ativo", Var.valueOf("Sim")),
						Var.valueOf("dataAtivacao", cronapi.dateTime.Operations.getNowNoHour()),
						Var.valueOf("id", dados));
				cronapi.util.Operations.callClientFunction(Var.valueOf("cronapi.screen.refreshDatasource"),
						Var.valueOf("Paciente"), Var.valueOf("true"));
				cronapi.util.Operations.callClientFunction(Var.valueOf("cronapi.screen.notify"), Var.valueOf("success"),
						Var.valueOf("Paciente Ativado!"));
				cronapi.util.Operations.callClientFunction(Var.valueOf("cronapi.screen.hideModal"),
						Var.valueOf("modalPesquisarPaciente"));
				return Var.VAR_NULL;
			}
		}.call();
	}

}
