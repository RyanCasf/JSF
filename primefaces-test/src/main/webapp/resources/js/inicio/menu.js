document.addEventListener("DOMContentLoaded", function() {
	const sidebar = document.querySelector('.sidebar');
	
	const scrollPos = localStorage.getItem('sidebarScrollPos');
	if (scrollPos && sidebar) {
		sidebar.scrollTop = scrollPos;
	}
	
	const menuLinks = document.querySelectorAll('.sidebar a');
	menuLinks.forEach(link => {
		link.addEventListener('click', () => {
			if (sidebar) {
				localStorage.setItem('sidebarScrollPos', sidebar.scrollTop);
			}
		});
	});
});