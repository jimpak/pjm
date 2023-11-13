import tkinter
import tkinter.font
from tkinter import *

window = Tk()
window.title('MyWindow')
window.geometry('400x400+300+300') # width, height, x좌표, y좌표
window.config(bg="skyblue")
window.resizable(1, 1)



#Tkinter 위젯 배치 방법
# 1) pack (상대위치)

btn1 = Button(window, text="Left", relief="solid",
              overrelief="groove", anchor="n")
# relief:테두리
# overrelief:버튼에 마우스를 위치했을때 반응
# anchor : 버튼안의 문자열 또는 이미지의 위치를 지정
# font : 버튼의 문자열 글꼴 설정
btn1.pack(side="left", fill="y") # 상대위치 지정
# fill:채우기

btn2 = Button(window, text="Right", font=tkinter.font.Font(size=15))
btn2.pack(side="right") # 상대위치 지정

# width=100 (100px을 의미), width=100m(100mm를 의미), 버튼의 width는 보통 6
font = tkinter.font.Font(family="맑은 고딕", size=20, slant="italic")
btn3 = Button(window, text="Top", width=15, height=5, anchor="se", font=font)
btn3.pack(side="top") # 상대위치 지정

btn4 = Button(window, text="Close", command=window.quit)
btn4.pack(side="bottom") # 상대위치 지정

# btn1.place(x=100, y=100) # 절대위치 지정

entry = Entry(window)
entry.pack() # 상대위치 지정안하면 top에 위치
window.mainloop()