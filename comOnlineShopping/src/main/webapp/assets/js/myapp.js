$(function(){
	// solving the active menu problem
	switch (menu) {

	case 'About-Us':
		$('#about').addClass('active');
		break;
	case 'Contact-Us':
		$('#contactUs').addClass('active');
		break;
	case 'Home':
		$('#home').addClass('active');
		break;
	
	default:
/*		if (menu == "Home")
			break;
		$('#listProducts').addClass('active');
		$('#a_' + menu).addClass('active');*/
		break;
	}
});