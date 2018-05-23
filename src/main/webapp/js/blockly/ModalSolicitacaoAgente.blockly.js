window.blockly = window.blockly || {};
window.blockly.js = window.blockly.js || {};
window.blockly.js.blockly = window.blockly.js.blockly || {};
window.blockly.js.blockly.ModalSolicitacaoAgente = window.blockly.js.blockly.ModalSolicitacaoAgente
		|| {};

/**
 * Descreva esta função...
 */
window.blockly.js.blockly.ModalSolicitacaoAgente.fechar = function() {
	this.cronapi.screen.hideModal("modalSolicitar");
}

/**
 * Descreva esta função...
 */
window.blockly.js.blockly.ModalSolicitacaoAgente.exibir = function() {
	this.cronapi.screen.showModal("modalSolicitar");
}
