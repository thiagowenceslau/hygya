window.blockly = window.blockly || {};
window.blockly.js = window.blockly.js || {};
window.blockly.js.blockly = window.blockly.js.blockly || {};
window.blockly.js.blockly.ModalMeusExames = window.blockly.js.blockly.ModalMeusExames
		|| {};

/**
 * Descreva esta função...
 */
window.blockly.js.blockly.ModalMeusExames.baixarRelatorio = function() {

	var idResultado, dados;
	this.cronapi.util.callServerBlocklyNoReturn(
			'blockly.AcessoExames:baixarPaciente', this.cronapi.screen
					.getScopeVariable('resultadoId'));
}

/**
 * Descreva esta função...
 */
window.blockly.js.blockly.ModalMeusExames.exibir = function(dados) {

	var idResultado, dados;
	idResultado = this.cronapi.object.getProperty(dados, 'id');
	this.cronapi.screen.createScopeVariable('resultadoId', idResultado);
	this.cronapi.screen.showModal("modalExame");
}

/**
 * Descreva esta função...
 */
window.blockly.js.blockly.ModalMeusExames.fechar = function() {

	var idResultado, dados;
	this.cronapi.screen.hideModal("modalExame");
}
