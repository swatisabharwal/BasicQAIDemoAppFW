
tatocsetup

=======================================================
basic_course			css		.page a
green_box				css  	.greenbox
main_frame 				xpath	//*[@id="main"]
child_frame 			xpath	//*[@id="child"]
box_1					css  	center>div[id=answer]:first-child
box_2					css 	body>#answer
repaint_link			css 	center a[onclick="reloadChildFrame();"]
repaint_proceed			css  	center a[onclick="gonext();"]
drag_box				css 	div[id=dragbox]
drop_box				css 	div[id="dropbox"]
drag_proceed			css 	a[onclick="gonext();"]
launch_popup			css 	a[onclick='launchwindow();']
text_window				css 	#name
submit_button			css 	#submit
launch_proceed			css 	a[onclick="gonext();"]
generate_token			css 	a[onclick= 'generateToken();']
token_text				css 	span[id=token]
advanced_course			xpath	//a[contains(@href,'tatoc/advanced')]
menu2_select			xpath	//*[@class="menutitle" and text()="Menu 2"]
gonext_click			xpath	//*[contains(@onclick, 'gonext') and text()="Go Next"]
symbol_text				xpath	//*[@id="symboldisplay" and @name="symboldisplay"]
name_value				xpath	//*[@id="name" and @type="text"]
password_value			xpath	//*[@id="passkey" and @type="password"]
proceed_button			xpath	//*[@id="submit" and @type="submit" and @value="Proceed"]
finish_msg				xpath	//h1[@class="finish" and text()="End"]
course_comp_msg			xpath	//span[@class="finish" and text()="Obstacle Course is Complete!"]
video_page_text			xpath	//h1[text()="Ooyala Video Player"]
error_msg				xpath	//h1[@class="error" and text()="Error"]

