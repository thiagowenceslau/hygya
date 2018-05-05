window.blockly = window.blockly || {};
window.blockly.js = window.blockly.js || {};
window.blockly.js.blockly = window.blockly.js.blockly || {};
window.blockly.js.blockly.ModalAgentesRegistro = window.blockly.js.blockly.ModalAgentesRegistro
		|| {};

/**
 * Descreva esta função...
 */
window.blockly.js.blockly.ModalAgentesRegistro.fechar = function() {
	this.cronapi.screen.hideModal("modalAutorizados");
}

/**
 * Descreva esta função...
 */
window.blockly.js.blockly.ModalAgentesRegistro.exibir = function() {
	this.cronapi.screen.showModal("modalAutorizados");
}
