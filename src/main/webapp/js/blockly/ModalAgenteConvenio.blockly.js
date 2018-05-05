window.blockly = window.blockly || {};
window.blockly.js = window.blockly.js || {};
window.blockly.js.blockly = window.blockly.js.blockly || {};
window.blockly.js.blockly.ModalAgenteConvenio = window.blockly.js.blockly.ModalAgenteConvenio
		|| {};

/**
 * Descreva esta função...
 */
window.blockly.js.blockly.ModalAgenteConvenio.fechar = function() {
	this.cronapi.screen.hideModal("modalAgenteC");
}

/**
 * Descreva esta função...
 */
window.blockly.js.blockly.ModalAgenteConvenio.exibir = function() {
	this.cronapi.screen.showModal("modalAgenteC");
}
