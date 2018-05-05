window.blockly = window.blockly || {};
window.blockly.js = window.blockly.js || {};
window.blockly.js.blockly = window.blockly.js.blockly || {};
window.blockly.js.blockly.ModalAgenteEAutorizados = window.blockly.js.blockly.ModalAgenteEAutorizados
		|| {};

/**
 * Descreva esta função...
 */
window.blockly.js.blockly.ModalAgenteEAutorizados.fechar = function() {
	this.cronapi.screen.hideModal("modalAgenteE");
}

/**
 * Descreva esta função...
 */
window.blockly.js.blockly.ModalAgenteEAutorizados.exibir = function() {
	this.cronapi.screen.showModal("modalAgenteE");
}
