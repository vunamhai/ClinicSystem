//** Xử lý các sự kiện khi click vào nút Thêm bác sĩ
let selectDocModal = document.getElementById('selectDoctorModal');
selectDocModal.addEventListener('show.bs.modal', function (event) {
    const button = event.relatedTarget
    const type = button.getAttribute('data-bs-select')
    const buttons = selectDocModal.querySelectorAll('.select-dismiss')

    // thêm target để back lại add service modal // else back lại edit service modal
    if (type === 'add') {
        buttons.forEach(button => {
            button.setAttribute('data-bs-target', '#addServiceModal')
        })
    } else {
        buttons.forEach(button => {
            button.setAttribute('data-bs-target', '#editServiceModal')
        })
    }
})

//** Xử lý các sự kiện khi click vào xóa bác sĩ
let deleteDocModal = document.getElementById('deleteDoctorModal');
deleteDocModal.addEventListener('show.bs.modal', function (event) {
    const button = event.relatedTarget
    const type = button.getAttribute('data-bs-delete')
    const buttons = deleteDocModal.querySelectorAll('.delete-dismiss')

    // thêm target để back lại add service modal // else back lại edit service modal
    if (type === 'add') {
        buttons.forEach(button => {
            button.setAttribute('data-bs-target', '#addServiceModal')
        })
    } else {
        buttons.forEach(button => {
            button.setAttribute('data-bs-target', '#editServiceModal')
        })
    }
})