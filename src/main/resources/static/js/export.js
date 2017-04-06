$("#btnExport").click(function(){
		$("#table2excel").table2excel({
		// exclude CSS class
		exclude: '.noExl',
		name: 'Worksheet Name',
		filename: 'SomeFile' //do not include extension
		
		  });
		
		});

$(function(){
	$('.js-currency').maskMoney({decimal: ',', thousands: '.', allowZero: true});	

});