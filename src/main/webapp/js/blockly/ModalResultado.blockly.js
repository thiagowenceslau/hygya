window.blockly = window.blockly || {};
window.blockly.js = window.blockly.js || {};
window.blockly.js.blockly = window.blockly.js.blockly || {};
window.blockly.js.blockly.ModalResultado = window.blockly.js.blockly.ModalResultado
		|| {};

/**
 * Descreva esta função...
 */
window.blockly.js.blockly.ModalResultado.fechar = function() {
	this.cronapi.screen.hideModal("modalResultado");
}

/**
 * ModalResultado
 */
window.blockly.js.blockly.ModalResultado.Executar = function() {
}

/**
 * Descreva esta função...
 */
window.blockly.js.blockly.ModalResultado.abrir = function() {
	this.cronapi.screen.showModal("modalResultado");
}
