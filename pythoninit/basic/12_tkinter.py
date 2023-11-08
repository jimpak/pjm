import tkinter
from tkinter import *

window = Tk()
window.title('MyWindow')
window.geometry('400x400+300+300') # width, height, x좌표, y좌표
window.config(bg="skyblue")
window.resizable(100, 100)

btn1 = Button(window, text="확인")
btn1.pack(side="left")

window.mainloop()