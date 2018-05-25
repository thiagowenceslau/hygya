window.blockly = window.blockly || {};
window.blockly.js = window.blockly.js || {};
window.blockly.js.blockly = window.blockly.js.blockly || {};
window.blockly.js.blockly.ModalResultado = window.blockly.js.blockly.ModalResultado
		|| {};

/**
 * Descreva esta função...
 */
window.blockly.js.blockly.ModalResultado.fechar = function() {

	var item;
	this.cronapi.screen.hideModal("modalResultado");
}

/**
 * ModalResultado
 */
window.blockly.js.blockly.ModalResultado.Executar = function() {

	var item;
}

/**
 * Descreva esta função...
 */
window.blockly.js.blockly.ModalResultado.abrir = function() {

	var item;
	this.cronapi.screen.showModal("modalResultado");
}
