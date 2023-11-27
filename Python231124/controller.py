from tkinter import messagebox

class MainController(object):

  def __new__(cls):
    if not hasattr(cls, 'instance'):
      cls.instance = super(MainController, cls).__new__(cls)
    return cls.instance

  def forwardingControl(self, cmd=None, *str):
    print("cmd", cmd, '/', "MainController id:", id(self))

    if cmd == 'Login':
      from ui.login_window import LoginWindow
      LoginWindow()
    elif cmd == 'List':
      from ui.list_window import ListWindow
      ListWindow()
    elif cmd == 'Join':
      from ui.join_window import JoinWindow
      JoinWindow()
    elif cmd == 'Info':
      from ui.info_window import InfoWindow
      InfoWindow()
    else:
      messagebox.showwarning("알림", "없는 명령입니다.")


# from student_management.controller import MainController as mc

ctrl = MainController()
ctrl.forwardingControl('Login')
