window.blockly = window.blockly || {};
window.blockly.js = window.blockly.js || {};
window.blockly.js.blockly = window.blockly.js.blockly || {};
window.blockly.js.blockly.ModalResultado = window.blockly.js.blockly.ModalResultado
		|| {};

/**
 * Descreva esta função...
 */
window.blockly.js.blockly.ModalResultado.baixar = function() {

	var item, dados, idResultado;
	this.cronapi.util.callServerBlocklyNoReturn(
			'blockly.AcessoExames:baixarPaciente', this.cronapi.screen
					.getScopeVariable('resultadoId'));
}

/**
 * Descreva esta função...
 */
window.blockly.js.blockly.ModalResultado.fechar = function() {

	var item, dados, idResultado;
	this.cronapi.screen.hideModal("modalTeste");
}

/**
 * Descreva esta função...
 */
window.blockly.js.blockly.ModalResultado.abrir = function(dados) {

	var item, dados, idResultado;
	idResultado = this.cronapi.object.getProperty(dados, 'resultado.id');
	this.cronapi.screen.createScopeVariable('resultadoId', idResultado);
	this.cronapi.screen.showModal("modalTeste");
}
