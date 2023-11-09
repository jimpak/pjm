import tkinter
import tkinter.ttk as ttk
import tkinter.font
from tkinter import *

root = Tk()
root.title('MyWindow layout grid')
root.geometry('400x400')
root.config(bg="white")
# resizable은 0,1 또는 True, False 사용
root.resizable(1,True)
font = tkinter.font.Font(family="맑은 고딕", size=13)

labelId = tkinter.Label(root, text="ID", font=font, background="white")
entryId = tkinter.Entry(root, relief="solid", borderwidth=1, font=font)
labelPass = tkinter.Label(root, text="Pass", font=font, background="white")
entryPass = tkinter.Entry(root, relief="solid", borderwidth=1, font=font, show="*")

labelId.place(x=10, y=8)
entryId.place(x=50, y=10)
labelPass.place(x=10, y=38)
entryPass.place(x=50, y=40)

date = [str(i) + "일" for i in range(1,32)]

combo = ttk.Combobox(root, height=5, values=date, state="readonly")
combo.place(x=10, y=70)

root.mainloop()