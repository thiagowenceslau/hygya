window.blockly = window.blockly || {};
window.blockly.js = window.blockly.js || {};
window.blockly.js.blockly = window.blockly.js.blockly || {};
window.blockly.js.blockly.ModalAgenteCAutorizados = window.blockly.js.blockly.ModalAgenteCAutorizados
		|| {};

/**
 * Descreva esta função...
 */
window.blockly.js.blockly.ModalAgenteCAutorizados.fechar = function() {
	this.cronapi.screen.hideModal("modalAgenteC");
}

/**
 * Descreva esta função...
 */
window.blockly.js.blockly.ModalAgenteCAutorizados.exibir = function() {
	this.cronapi.screen.showModal("modalAgenteC");
}
