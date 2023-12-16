from tkinter import *
from tkinter import messagebox
from util import ui_util as tool
from dao.dao_student import StudentDao


class JoinWindow:
    def __init__(self):
        from controller import MainController
        self.ctrl = MainController()
        self.join = Tk()
        self.id, self.pw, self.name = StringVar(), StringVar(), StringVar()
        self.dao = StudentDao()
        Label(self.join, text="ID : ") \
            .grid(row=0, column=0, padx=10, pady=10)
        Label(self.join, text="Password : ") \
            .grid(row=1, column=0, padx=10, pady=10)
        Label(self.join, text="Name : ") \
            .grid(row=2, column=0, padx=10, pady=10)

        self.ent_id = Entry(self.join, textvariable=self.id)
        self.ent_id.grid(row=0, column=1, padx=10, pady=10)

        self.ent_pw = Entry(self.join, textvariable=self.pw, show="*")
        self.ent_pw.grid(row=1, column=1, padx=10, pady=10)

        self.ent_name = Entry(self.join, textvariable=self.name)
        self.ent_name.grid(row=2, column=1, padx=10, pady=10)

        Button(self.join, text="Join", width=10, command=self.check_join) \
            .grid(row=3, column=0, padx=10, pady=10, sticky='e')
        Button(self.join, text="Cancel", width=10, command=self.go_login) \
            .grid(row=3, column=1, padx=10, pady=10, sticky='')

        self.ent_id.focus()
        tool.center_win(self.join, 270, 200)

        self.join.mainloop()

    def check_join(self):
        if str(self.id.get()) == "":
            messagebox.showinfo("알림", "ID를 확인해주세요")
            self.ent_id.focus()
            return

        if str(self.pw.get()) == "":
            messagebox.showinfo("알림", "비밀번호를 확인해주세요")
            self.ent_pw.focus()
            return

        from vo.student_vo import Student
        s = Student()
        s.id = self.id.get()
        s.pw = self.pw.get()
        s.name = self.name.get()
        result = self.dao.insert_one(s)
        if result == None:
            messagebox.showwarning("알림", "회원가입에 실패하였습니다.")
            self.id.set('')
            self.pw.set('')
            self.name.set('')
            self.ent_id.focus()
        else:
            self.join.destroy()
            self.ctrl.forwardingControl('Login')

    def go_login(self):
        self.join.destroy()
        self.ctrl.forwardingControl('Login')
