/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
var MedicalExpertisesAPI = (function() {
  var endpoint = "//localhost:8084/clinica-legal/medical_expertises";
  return {
    list: function(callback) {
      $.ajax(endpoint, {
        type: 'GET',
        dataType: 'json',
        success: function(data) {
          if (callback) {
            callback(null, data);
          }
        },
        error: function(err) {
          if(callback) {
            callback(err);
          }
        }
      });
    },
    create: function(data, callback) {
      if(!data) {
        if (callback) {
          callback(true);
        }
        return;
      }
      $.ajax(endpoint, {
        type: 'POST',
        data: JSON.stringify(data),
        success: function(data) {
          if (callback) {
            callback(null, data);
          }
        },
        error: function(err) {
          if(callback(err));
        }
      });
    }
  };
})();