window.blockly = window.blockly || {};
window.blockly.js = window.blockly.js || {};
window.blockly.js.blockly = window.blockly.js.blockly || {};
window.blockly.js.blockly.ModalMeusExames = window.blockly.js.blockly.ModalMeusExames
		|| {};

var item;

/**
 * Descreva esta função...
 */
window.blockly.js.blockly.ModalMeusExames.fechar = function() {
	this.cronapi.screen.hideModal("modal12384");
}

/**
 * Descreva esta função...
 */
window.blockly.js.blockly.ModalMeusExames.exibir = function() {
	this.cronapi.screen.showModal("modal12384");
}
