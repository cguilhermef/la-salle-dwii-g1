/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
var SectionExpertises = function() {
  var api = MedicalExpertisesAPI;
  var listDOM = $('#expertise-list');
  var modalDOM = $('#expertise-modal');  
  
  var updateList = function() {
    api.list(function(err, data){
      if (err) {
        return;
      }
      listDOM.html('');
      $(data.filter(d => d.active)).each( function(i, o) {
        listDOM.append('<li>' + o.name + '</li>');
      });
    });
  }
  
  updateList();
  
  $(document).on('click', '#expertise-form-btn', function(e) {
    e.target.disabled = true;
    var input = $('#expertise-form input[name=name]');
    api.create({
      name: input.val()
    }, function(err, data) { 
      e.target.disabled = false;
      input.val('');
      modalDOM.modal('toggle');
      updateList();
    });
  });
};

