window.blockly = window.blockly || {};
window.blockly.js = window.blockly.js || {};
window.blockly.js.blockly = window.blockly.js.blockly || {};
window.blockly.js.blockly.ProfissionalEntidade = window.blockly.js.blockly.ProfissionalEntidade
		|| {};

var item, ex;

/**
 * ProfissionalEntidade
 */
window.blockly.js.blockly.ProfissionalEntidade.Atualizar = function() {
	try {
		this.cronapi.util
				.callServerBlocklyNoReturn('blockly.ProfissionalEntidade:AtualizarProfissional');
		this.cronapi.screen.notify('success', 'Salvo com sucesso!\n');
	} catch (ex_exception) {
		ex = ex_exception;
		this.cronapi.screen.notify('error',
				String('Ocorreu o seguinte erro ao tentar salvar: ')
						+ String(ex));
	} finally {
	}
	return 'ok';
}
