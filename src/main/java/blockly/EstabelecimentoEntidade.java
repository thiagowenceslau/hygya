package blockly;

import cronapi.*;
import cronapi.rest.security.CronappSecurity;
import java.util.concurrent.Callable;

@CronapiMetaData(type = "blockly")
@CronappSecurity
public class EstabelecimentoEntidade {

	public static final int TIMEOUT = 300;

	/**
	 *
	 * @param dados
	 * @return Var
	 */
	// ConvenioEntidade
	public static Var InserirUsuario(Var dados) throws Exception {
		return new Callable<Var>() {

			private Var estabelecimento = Var.VAR_NULL;
			private Var senha = Var.VAR_NULL;
			private Var userId = Var.VAR_NULL;
			private Var nome = Var.VAR_NULL;
			private Var email = Var.VAR_NULL;

			public Var call() throws Exception {
				estabelecimento = cronapi.object.Operations.getObjectField(dados, Var.valueOf("id"));
				senha = cronapi.screen.Operations
						.getValueOfField(Var.valueOf("EstabelecimentoDeSaude.active.user.password"));
				userId = cronapi.util.Operations.generateUUID();
				nome = cronapi.object.Operations.getObjectField(dados, Var.valueOf("nome"));
				email = cronapi.object.Operations.getObjectField(dados, Var.valueOf("email"));
				cronapi.database.Operations.insert(Var.valueOf("app.entity.User"), Var.valueOf("password", senha),
						Var.valueOf("name", nome), Var.valueOf("bloqueado", Var.valueOf("Não")),
						Var.valueOf("estabelecimentoDeSaude", estabelecimento), Var.valueOf("id", userId),
						Var.valueOf("login", email), Var.valueOf("email", email));
				cronapi.database.Operations.insert(Var.valueOf("app.entity.Role"),
						Var.valueOf("id", Var.valueOf("Estabelecimento Administrativo")), Var.valueOf("user", userId));
				return dados;
			}
		}.call();
	}

	/**
	 *
	 * @param dados
	 */
	// Descreva esta função...
	public static void remove_usuario_estabelecimento(Var dados) throws Exception {
		new Callable<Var>() {

			private Var consulta = Var.VAR_NULL;

			public Var call() throws Exception {
				consulta = cronapi.database.Operations.query(Var.valueOf("app.entity.EstabelecimentoDeSaude"),
						Var.valueOf("select e from EstabelecimentoDeSaude e where e.id = :id"),
						Var.valueOf("id", cronapi.object.Operations.getObjectField(dados, Var.valueOf("id"))));
				while (cronapi.database.Operations.hasElement(consulta).getObjectAsBoolean()) {
					cronapi.database.Operations.execute(Var.valueOf("app.entity.Role"),
							Var.valueOf("delete from Role where user.id = :id"), Var.valueOf("id",
									cronapi.database.Operations.getField(consulta, Var.valueOf("this[0].id"))));
					cronapi.database.Operations.remove(Var.valueOf("app.entity.User"),
							cronapi.database.Operations.getActiveData(consulta));
					cronapi.database.Operations.next(consulta);
				} // end while
				return Var.VAR_NULL;
			}
		}.call();
	}

}
