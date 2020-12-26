$(function(){
	// solving the active menu problem
	switch (menu) {

	case 'About-Us':
		$('#about').addClass('active');
		break;
	case 'Contact-Us':
		$('#contactUs').addClass('active');
		break;
	case 'All Products':
		$('#listProduct').addClass('active');
		break;
	case 'Home':
		$('#home').addClass('active');
		break;
	
	default:
		if (menu == "Home")
			break;
		$('#listProduct').addClass('active');
		$('#a_' + menu).addClass('active');
		break;
	}
	
	
	
	// code for jquery dataTable
	var $table = $('#productListTable');

	// execute the below code only where we have this table
	if ($table.length) {
		// console.log('Inside the table!');

		var jsonUrl = '';
		if (window.categoryId == '') {
			jsonUrl = window.contextRoot + '/json/data/all/products';
		} else {
			jsonUrl = window.contextRoot + '/json/data/category/'
					+ window.categoryId + '/products';
		}

		$table
				.DataTable({

					lengthMenu : [ [ 3, 5, 10, -1 ],
							[ '3 Records', '5 Records', '10 Records', 'ALL' ] ],
					pageLength : 5,
					ajax : {
						url : jsonUrl,
						dataSrc : ''
					},
					columns : [
							{
								data : 'code'
							},
							{
								data : 'name'
							},
							{
								data : 'brand'
							},
							{
								data : 'unitPrice'
							},
							{
								data : 'quantity'
							},
							{
								data : 'id'
							} ]
				});
	}
	
});