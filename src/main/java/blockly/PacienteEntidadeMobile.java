package blockly;

import cronapi.*;
import cronapi.rest.security.CronappSecurity;
import java.util.concurrent.Callable;

@CronapiMetaData(type = "blockly")
@CronappSecurity
public class PacienteEntidadeMobile {

	public static final int TIMEOUT = 300;

	/**
	 *
	 * @return Var
	 */
	// PacienteEntidadeMobile
	public static Var atualizar() throws Exception {
		return new Callable<Var>() {

			private Var login = Var.VAR_NULL;
			private Var usuario = Var.VAR_NULL;
			private Var idUser = Var.VAR_NULL;
			private Var consulta = Var.VAR_NULL;
			private Var idPaciente = Var.VAR_NULL;

			public Var call() throws Exception {
				login = cronapi.util.Operations.getCurrentUserName();
				usuario = cronapi.database.Operations.query(Var.valueOf("app.entity.User"),
						Var.valueOf("select u from User u where u.login = :login"), Var.valueOf("login", login));
				idUser = cronapi.database.Operations.getField(usuario, Var.valueOf("this[0].id"));
				consulta = cronapi.database.Operations.query(Var.valueOf("app.entity.Paciente"),
						Var.valueOf("select p from Paciente p where p.user.id = :userId"),
						Var.valueOf("userId", idUser));
				idPaciente = cronapi.database.Operations.getField(consulta, Var.valueOf("this[0].id"));
				cronapi.database.Operations
						.execute(Var.valueOf("app.entity.Paciente"),
								Var.valueOf(
										"update Paciente set bairro = :bairro, cep = :cep, cidade = :cidade, complemento = :complemento, cpf = :cpf, dataNascimento = :dataNascimento, endereco = :endereco, estado = :estado, nome = :nome, numero = :numero, sexo = :sexo, telefone1 = :telefone1, telefone2 = :telefone2 where id = :id"),
								Var.valueOf("bairro",
										cronapi.screen.Operations
												.getValueOfField(Var.valueOf("Paciente.active.bairro"))),
								Var.valueOf("cep",
										cronapi.screen.Operations.getValueOfField(Var.valueOf("Paciente.active.cep"))),
								Var.valueOf("cidade",
										cronapi.screen.Operations
												.getValueOfField(Var.valueOf("Paciente.active.cidade"))),
								Var.valueOf("complemento",
										cronapi.screen.Operations
												.getValueOfField(Var.valueOf("Paciente.active.complemento"))),
								Var.valueOf("cpf",
										cronapi.screen.Operations.getValueOfField(Var.valueOf("Paciente.active.cpf"))),
								Var.valueOf("dataNascimento",
										cronapi.screen.Operations
												.getValueOfField(Var.valueOf("Paciente.active.dataNascimento"))),
								Var.valueOf("endereco",
										cronapi.screen.Operations
												.getValueOfField(Var.valueOf("Paciente.active.endereco"))),
								Var.valueOf("estado",
										cronapi.screen.Operations
												.getValueOfField(Var.valueOf("Paciente.active.estado"))),
								Var.valueOf("nome",
										cronapi.screen.Operations.getValueOfField(Var.valueOf("Paciente.active.nome"))),
								Var.valueOf("numero",
										cronapi.screen.Operations
												.getValueOfField(Var.valueOf("Paciente.active.numero"))),
								Var.valueOf("sexo",
										cronapi.screen.Operations.getValueOfField(Var.valueOf("Paciente.active.sexo"))),
								Var.valueOf("telefone1",
										cronapi.screen.Operations
												.getValueOfField(Var.valueOf("Paciente.active.telefone1"))),
								Var.valueOf("telefone2",
										cronapi.screen.Operations
												.getValueOfField(Var.valueOf("Paciente.active.telefone2"))),
								Var.valueOf("id", idPaciente));
				cronapi.util.Operations.callClientFunction(Var.valueOf("cronapi.screen.notify"), Var.valueOf("success"),
						Var.valueOf("Cadastro atualizado com sucesso!"));
				System.out.println(idPaciente.getObjectAsString());
				return Var.VAR_NULL;
			}
		}.call();
	}

}
