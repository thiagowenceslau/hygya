(function() {
  'use strict';

  this.cronapi = {};

   /**
   * @categoryName Minhas Funções
   */
  this.cronapi.myfunctions = {};
  
  /**
   * @type function
   * @name Limpar Campos
   * @description Limpar os campos a partir do id do formulário
   * @multilayer false
   * @param {ObjectType.STRING} input Param Description
   * @returns {ObjectType.STRING}
   */
  this.cronapi.myfunctions.limparCampos = function(/** @type {ObjectType.STRING} @description Parâmetro: Descrição do parâmetro */input) {
    document.getElementById(input).reset();
  };
  

}).bind(window)();