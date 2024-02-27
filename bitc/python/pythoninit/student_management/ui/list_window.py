from tkinter import ttk
import tkinter
from student_management.dao.dao_student import StudentDao
from student_management.util import ui_util as tool
import tkinter.font

class ListWindow:
  def __init__(self):
    from student_management.controller import MainController
    self.ctrl = MainController()
    self.dao = StudentDao()

    self.list = tkinter.Tk()
    self.list.title("Student List")

    font = tkinter.font.Font(family="맑은 고딕", size=30, slant="italic")
    self.lbl = tkinter.Label(self.list, text="Student List", font=font)
    self.lbl.config(bg="white")
    self.lbl.pack(side="top", fill="both", padx=10, pady=10)


    # treeview 표
    self.trv = tkinter.ttk.Treeview(
      self.list, columns=["stdNo", "이름", "ID"],
      displaycolumns=["stdNo", "이름", "ID"])
    self.trv.pack(side="bottom", fill="both", padx=10, pady=10)

    self.trv.column("#0", width=100)
    self.trv.heading("#0", text="index")

    self.trv.column("#1", width=100, anchor="center")
    self.trv.heading("stdNo", text="stdNo", anchor="center")

    self.trv.column("#2", width=150, anchor="center")
    self.trv.heading("이름", text="이름", anchor="center")

    self.trv.column("#3", width=150, anchor="center")
    self.trv.heading("ID", text="ID", anchor="center")

    self.trv.bind('<ButtonRelease-1>', self.click_item)


    trv_list = self.dao.get_all()
    if trv_list != None:
      for i in range(len(trv_list)):  # iid =index id
        self.trv.insert('', 'end', text=i, values=trv_list[i], iid=str(i) + ")")
    tool.center_win(self.list, 540, 300)
    self.list.resizable(False, False)

    self.list.mainloop()

  def click_item(self, event):
    selectedItem = self.trv.focus()
    getValue = self.trv.item(selectedItem).get('values')  # 딕셔너리의 값만 가져오기
    str = f'{getValue[0]},{getValue[1]},{getValue[2]},{getValue[3]}'
    self.list.destroy()
    self.ctrl.forwardingControl('Info', str)