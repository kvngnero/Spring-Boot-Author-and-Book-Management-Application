document.addEventListener('DOMContentLoaded', function() {
    // Flash message auto-hide
    const flashMessages = document.querySelectorAll('.alert');
    if (flashMessages.length > 0) {
        setTimeout(() => {
            flashMessages.forEach(message => {
                message.classList.add('fade-out');
                setTimeout(() => {
                    message.remove();
                }, 500);
            });
        }, 3000);
    }

    // Confirmation dialogs for delete actions
    const deleteButtons = document.querySelectorAll('.delete-confirm');
    deleteButtons.forEach(button => {
        button.addEventListener('click', function(e) {
            if (!confirm('Are you sure you want to delete this item? This action cannot be undone.')) {
                e.preventDefault();
            }
        });
    });

    // Form validation
    const forms = document.querySelectorAll('form.needs-validation');
    forms.forEach(form => {
        form.addEventListener('submit', function(event) {
            if (!form.checkValidity()) {
                event.preventDefault();
                event.stopPropagation();
            }
            form.classList.add('was-validated');
        });
    });

    // Search input focus
    const searchInputs = document.querySelectorAll('.search-input');
    searchInputs.forEach(input => {
        input.addEventListener('focus', function() {
            this.parentElement.classList.add('search-focus');
        });
        input.addEventListener('blur', function() {
            this.parentElement.classList.remove('search-focus');
        });
    });

    // Responsive navigation menu
    const navToggle = document.querySelector('.nav-toggle');
    if (navToggle) {
        navToggle.addEventListener('click', function() {
            const nav = document.querySelector('.nav');
            nav.classList.toggle('nav-open');
        });
    }

    // Animated entrance for book and author cards
    const cards = document.querySelectorAll('.card');
    if (cards.length > 0) {
        cards.forEach((card, index) => {
            setTimeout(() => {
                card.classList.add('slide-up');
            }, index * 100); // Stagger the animation
        });
    }

    // Form date picker enhancement
    const dateInputs = document.querySelectorAll('input[type="date"]');
    dateInputs.forEach(input => {
        if (input.value === '') {
            const today = new Date();
            const year = today.getFullYear();
            let month = today.getMonth() + 1;
            let day = today.getDate();
            
            month = month < 10 ? '0' + month : month;
            day = day < 10 ? '0' + day : day;
            
            input.max = `${year}-${month}-${day}`; // Set max date to today
        }
    });
});