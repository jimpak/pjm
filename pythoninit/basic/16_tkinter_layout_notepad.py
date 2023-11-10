import tkinter as tk
from tkinter import *
from tkinter.filedialog import *
from tkinter import scrolledtext
from tkinter.messagebox import askyesno

def new_file():
    # if(len(text_area.get(1.0, END).strip()) > 0): # space 공백만 입력 시 else로 진입. 공백입력 시에도 알림창 떠야함.
    if (len(str(text_area.get(1.0, END))) > 1): # space 공백만 입력한 경우에도 알림창이 뜨도록 설정.
        answer = askyesno("확인", "저장하시겠습니까?")
        if(answer == True):
            save_file()
            text_area.delete(1.0, END)
        else: text_area.delete(1.0, END)
    else:
        text_area.delete(1.0, END)


def save_file():
    f = asksaveasfilename(
        initialfile='noname.txt',
        defaultextension='.txt',
        filetypes=[('text Files', '.txt')]
    )

    if (f.strip() != ""):
        save_tmp = str(text_area.get(1.0, END))
        with open(f, 'w', encoding='UTF-8') as file:
            file.write(save_tmp + "\n")

def open_file():
    f = askopenfilename(
        initialdir='/',
        title="Select a file",
        filetypes = [('text Files', '.txt'), ('Python Files', '.py'), ('CSV Files', '.csv')]
    )
    text_area.delete(1.0, END) # 기존 텍스트 지우기
    with open(f, 'r', encoding='UTF-8') as file:
        lines = file.readlines()
        str = ''
        for line in lines:
            str += line + '\n'
        text_area.pack()
        text_area.insert(tk.CURRENT, str)


def info():
  info_view = Toplevel(window)
  info_view.geometry('300x50+350+400')
  info_view.title('Maker: LGH')
  lb = Label(info_view, text="널 위해 준비했어!!")
  lb.pack()

window = Tk()
window.title('MyNotepad')
window.geometry('400x400+300+300')
window.config(bg="white")
window.resizable(1,True)


#메뉴프레임생성
menu = Menu(window)

# 첫번째 메뉴
# tearoff=0 : Menu의 첫번째 항목에는 절취선이 있는데 이 항목을 지칭. 표시안할 경우 0
menu_1 = Menu(menu, tearoff=0)
menu_1.add_command(label="New", command=new_file)
menu_1.add_command(label="Open", command=open_file)
menu_1.add_command(label="Save", command=save_file)
menu_1.add_separator()
menu_1.add_command(label="Close", command=window.destroy)
menu.add_cascade(label="File", menu=menu_1)

# 두번째 메뉴
menu_2 = Menu(menu, tearoff=0)
menu_2.add_command(label="Info", command=info)
# menu_2.add_command(label="Help")
menu.add_cascade(label="Help", menu=menu_2)

# scrolledtext 창에 추가하기
text_area = scrolledtext.ScrolledText(window)
# window.grid_rowconfigure(0, weight=1)
# window.grid_columnconfigure(0, weight=1)
# text_area.grid(sticky=N+E+S+W)
text_area.config(width="100", height="100")
text_area.pack(fill="both")

# 메뉴 본창에 붙이기
window.config(menu=menu)

window.mainloop()