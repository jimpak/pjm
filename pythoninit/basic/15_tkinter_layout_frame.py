import tkinter as tk
import tkinter.ttk as ttk
import tkinter.font
from tkinter import *

root = Tk()
root.title('MyWindow layout grid')
root.geometry('400x400')
root.config(bg="white")
# resizable은 0,1 또는 True, False 사용
root.resizable(1,True)
font = tkinter.font.Font(family="맑은 고딕", size=11)

frame_top = tk.Frame(root)
# frame_top.pack(side="top")
frame_top.place(x=10, y=10)
entry = tk.Entry(frame_top, width=22)
entry.pack(side="left")
btn_clear = tk.Button(frame_top, text="지우기", width=10)
btn_clear.pack(side="right")

frame_bot = tk.Frame(root)
# frame_bot.pack(side="bottom")
frame_bot.place(x=300, y=10)

btn0 = tkinter.Button(frame_bot, text="0", width=6)
btn1 = tkinter.Button(frame_bot, text="1", width=6)
btn2 = tkinter.Button(frame_bot, text="2", width=6)
btn3 = tkinter.Button(frame_bot, text="3", width=6)
btn4 = tkinter.Button(frame_bot, text="4", width=6)
btn5 = tkinter.Button(frame_bot, text="5", width=6)
btn6 = tkinter.Button(frame_bot, text="6", width=6)
btn7 = tkinter.Button(frame_bot, text="7", width=6)
btn8 = tkinter.Button(frame_bot, text="8", width=6)
btn9 = tkinter.Button(frame_bot, text="9", width=6)

btn1.grid(row=3, column=1)
btn2.grid(row=3, column=2)
btn3.grid(row=3, column=3)
btn4.grid(row=2, column=1)
btn5.grid(row=2, column=2)
btn6.grid(row=2, column=3)
btn7.grid(row=1, column=1)
btn8.grid(row=1, column=2)
btn9.grid(row=1, column=3)

# buttonAbs = tk.Button(frame_top, text="절대 좌표 프레임에 속한 버튼")

root.mainloop()