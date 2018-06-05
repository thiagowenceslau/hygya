window.blockly = window.blockly || {};
window.blockly.js = window.blockly.js || {};
window.blockly.js.blockly = window.blockly.js.blockly || {};
window.blockly.js.blockly.AcessoExames = window.blockly.js.blockly.AcessoExames
		|| {};

/**
 * Descreva esta função...
 */
window.blockly.js.blockly.AcessoExames.autorizar = function(rowData) {

	var idAutorizacao, rowData, dados;
	idAutorizacao = this.cronapi.object.getProperty(rowData, 'id');
	this.cronapi.util.callServerBlocklyNoReturn(
			'blockly.AcessoExames:autorizar', idAutorizacao);
	this.cronapi.screen.refreshDatasource("AutorizacaoAcessoExame", 'true');
	this.cronapi.screen.notify('success', 'Solicitação autorizada');
}

/**
 * AcessoExames
 */
window.blockly.js.blockly.AcessoExames.recusar = function(dados) {

	var idAutorizacao, rowData, dados;
	idAutorizacao = this.cronapi.object.getProperty(dados, 'id');
	this.cronapi.util.callServerBlocklyNoReturn('blockly.AcessoExames:recusar',
			idAutorizacao);
	this.cronapi.screen.refreshDatasource("AutorizacaoAcessoExame", 'true');
	this.cronapi.screen.notify('success', 'Solicitação recusada');
}
