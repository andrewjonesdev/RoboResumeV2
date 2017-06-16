<!DOCTYPE html>
<html>
<head>
<title>Resume Work Shop</title>
<!-- Meta -->
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<meta name="description"
	content="Responsive HTML5 Resume/CV Template for Developers">
<meta name="author" content="Xiaoying Riley at 3rd Wave Media">
<link rel="shortcut icon" href="favicon.ico">
<link
	href='https://fonts.googleapis.com/css?family=Roboto:400,500,400italic,300italic,300,500italic,700,700italic,900,900italic'
	rel='stylesheet' type='text/css'>
<!-- Global CSS -->
<link rel="stylesheet"
	href="assets/plugins/bootstrap/css/bootstrap.min.css">
<!-- Plugins CSS -->
<link rel="stylesheet"
	href="assets/plugins/font-awesome/css/font-awesome.css">

<!-- Theme CSS -->
<link id="theme-style" rel="stylesheet" href="assets/css/styles.css">
<!-- HTML5 shim and Respond.js for IE8 support of HTML5 elements and media queries -->
<!--[if lt IE 9]>
      <script src="https://oss.maxcdn.com/html5shiv/3.7.2/html5shiv.min.js"></script>
      <script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script>
    <![endif]-->
</head>
<body>



	<div class="wrapper">
		<h1 style="color: white;">Resume&nbsp;Generator</h1>


		<div>
			<div class="main-wrapper"
				style="-webkit-column-count: 3; /* Chrome, Safari, Opera */ -moz-column-count: 3; /* Firefox */ column-count: 3; -webkit-column-gap: 300px; /* Chrome, Safari, Opera */ -moz-column-gap: 300px; /* Firefox */ column-gap: 300px;">
				<div class="profile-container">
					<h2 class="email">Basic&nbsp;Info</h2>
					<h5 class="error">${errorResume}</h5>
					<h5 class="added">${updateResume}</h5>
					<form action="Resume" method="post">
						<h3 class="email">Enter&nbsp;First&nbsp;name:</h3>
						<input type="text" name="firstName" value="John"
							style="color: #545E6C;" />
						<h3 class="email">Enter&nbsp;Last&nbsp;name:</h3>
						<input type="text" name="lastName" value="Doe"
							style="color: #545E6C;">
						<div class="contact-container container-block">
							<h3 class="email">
								Enter&nbsp;Email:
							</h3>
						</div>
						<input type="text" name="email" value="john.doe@email.com"
							style="color: #545E6C;"><br /> <br /> <input
							type="submit" value="Update" style="color: #545E6C;" />
						<!--<input type="reset" value="Clear">-->
					</form>

				</div>
				<h2 class="email">Education</h2>
				<h5 class="error">${errorEducation}</h5>
				<h5 class="added">${addEducation}</h5>
				<h5 class="entry">${entryEducation}</h5>
				<form action="Education" method="post">
					<h3 class="email">Enter&nbsp;College&nbsp;Degree:</h3>
					<input type="text" name="degree" value="Masters of Fine Arts" /><br />
					<br />
					<h3 class="email">Enter&nbsp;Focus&nbsp;of&nbsp;Study:</h3>
					<input type="text" name="courseOfStudy" value="UI/UX"><br />
					<br />
					<h3 class="email">Enter&nbsp;School:</h3>
					<input type="text" name="school" value="Stanford University"><br />
					<br />
					<h3 class="email">Enter&nbsp;Graduation&nbsp;Year:</h3>
					<input type="number" name="gradYear" min="1950" max="2020"
						value="2016"><br /> <br /> <input type="submit"
						value="Update" />
					<!--<input type="reset" value="Clear">-->
				</form>
				<h2 class="email">Work&nbsp;Experience</h2>
				<h5 class="error">${errorWork}</h5>
				<h5 class="added">${addWork}</h5>
				<h5 class="entry">${entryWork}</h5>
				<form action="Work" method="post">
					<h3 class="email">Enter&nbsp;Job&nbsp;Title:</h3>
					<input type="text" name="jobTitle" value="Coder" /><br /> <br />
					<h3 class="email">Enter&nbsp;Employer:</h3>
					<input type="text" name="employer" value="Google"><br /> <br />
					<h3 class="email">Enter&nbsp;Start&nbsp;Month:</h3>
					<input type="number" name="startMonth" min="1" max="12" value="5"><br />
					<br />
					<h3 class="email">Enter&nbsp;Start&nbsp;Year:</h3>
					<input type="number" name="startYear" min="1950" max="2017"
						value="2016"><br /> <br />
					<h3 class="email">Enter&nbsp;End&nbsp;Month:</h3>
					<input type="number" name="endMonth" min="1" max="12" value="6"><br />
					<br />
					<h3 class="email">Enter&nbsp;End&nbsp;Year:</h3>
					<input type="number" name="endYear" min="1950" max="2017"
						value="2017"><br /> <br /> <input type="submit"
						value="Update" /><br /> <br />
					<!--<input type="reset" value="Clear">-->
				</form>
				<form action="Duty" method="post">
				<h5 class="error">${error}</h5>
				<h5 class="added">${added}</h5>
					<h3 class="email">Enter&nbsp;Duty:</h3>
					<input type="text" name="dutyTitle" value="Write Code" /><br /> <br />
					<input type="submit" value="Update" />
					<!--<input type="reset" value="Clear">-->
				</form>
				<div>
					<h2 class="email">Professional&nbsp;Skills</h2>
					<h5 class="error">${errorSkill}</h5>
					<h5 class="added">${addSkill}</h5>
					<h5 class="entry">${entrySkill}</h5>
					<form action="Skill" method="post">
						<h3 class="email">Enter&nbsp;Skill:</h3>
						<input type="text" name="skillName" value="Java"
							style="color: #545E6C;" /><br /> <br />
						<h3 class="email">Enter&nbsp;Rating:</h3>
						<input type="text" name="rating" value="Godlike"
							style="color: #545E6C;"><br /> <br /> <input
							type="submit" value="Update" style="color: #545E6C;" />
						<!--<input type="reset" value="Clear">-->
					</form>
				</div>
				<div>
					<h3 class="email">Finalize</h3>
					<form action="Finalize" method="post">
						<input type="submit" value="Generate Resume"
							style="color: #545E6C;" />
						<!--<input type="reset" value="Clear">-->
					</form>
				</div>
				<div>
					<h3 class="email">Clear</h3>
					<form action="Clear" method="post">
						<input type="submit" value="Clear Resume"
							style="color: #545E6C;" />
						<!--<input type="reset" value="Clear">-->
					</form>
				</div>
			</div>
		</div>
	</div>

</body>
</html>