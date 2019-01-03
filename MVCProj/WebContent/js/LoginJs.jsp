
$(document).ready(function() 
		{
$(':text, :password').focusin(function()
		{
			$(this).css('background-color', '#ced180');
		}
		);
$(':text, :password').blur(function()
		{
			$(this).css('background-color', '#fff');
		}
		);
$(':button').click(function()
		{
			$(this).attr('value', 'Please wait...');
		}
		);

		}
		);
		
		
