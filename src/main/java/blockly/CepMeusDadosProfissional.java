package blockly;

import cronapi.*;
import cronapi.rest.security.CronappSecurity;
import java.util.concurrent.Callable;

@CronapiMetaData(type = "blockly")
@CronappSecurity
public class CepMeusDadosProfissional {

	public static final int TIMEOUT = 300;

	/**
	 *
	 * @return Var
	 */
	// BuscarCep
	public static Var buscarCepProfissional() throws Exception {
		return new Callable<Var>() {

			private Var url = Var.VAR_NULL;
			private Var retornaCep = Var.VAR_NULL;

			public Var call() throws Exception {
				url = Var.valueOf(Var.valueOf("https://viacep.com.br/ws/").toString()
						+ cronapi.screen.Operations.getValueOfField(Var.valueOf("Profissional.active.cep")).toString()
						+ Var.valueOf("/json").toString());
				retornaCep = cronapi.util.Operations.getURLFromOthers(Var.valueOf("GET"),
						Var.valueOf("application/json"), url, Var.VAR_NULL, Var.VAR_NULL);
				retornaCep = cronapi.json.Operations.toJson(retornaCep);
				cronapi.util.Operations.callClientFunction(Var.valueOf("cronapi.screen.changeValueOfField"),
						Var.valueOf("Profissional.active.endereco"),
						cronapi.json.Operations.getJsonOrMapField(retornaCep, Var.valueOf("logradouro")));
				cronapi.util.Operations.callClientFunction(Var.valueOf("cronapi.screen.changeValueOfField"),
						Var.valueOf("Profissional.active.cidade"),
						cronapi.json.Operations.getJsonOrMapField(retornaCep, Var.valueOf("localidade")));
				cronapi.util.Operations.callClientFunction(Var.valueOf("cronapi.screen.changeValueOfField"),
						Var.valueOf("Profissional.active.bairro"),
						cronapi.json.Operations.getJsonOrMapField(retornaCep, Var.valueOf("bairro")));
				cronapi.util.Operations.callClientFunction(Var.valueOf("cronapi.screen.changeValueOfField"),
						Var.valueOf("Profissional.active.estado"),
						cronapi.json.Operations.getJsonOrMapField(retornaCep, Var.valueOf("uf")));
				return Var.VAR_NULL;
			}
		}.call();
	}

}
