from tkinter import *
import xlsxwriter
window = Tk()
photo = PhotoImage(file = './GIF2/picture06.gif')
h = photo.height()
w = photo.width()

photoR=[ [0 for _ in range(h)] for _ in range(w)]
photoG=[ [0 for _ in range(h)] for _ in range(w)]
photoB=[ [0 for _ in range(h)] for _ in range(w)]

for i in range(w) :
    for k in range(h) :
        r, g, b = photo.get(i,k)
        photoR[i][k] = r
        photoG[i][k] = g
        photoB[i][k] = b

workbook = xlsxwriter.Workbook('./Excel/picture06_art.xlsx')
worksheetR = workbook.add_worksheet('photoR')
worksheetG = workbook.add_worksheet('photoG')
worksheetB = workbook.add_worksheet('photoB')

worksheetR.set_column(0, w - 1, 1.0)  # 약 0.34
worksheetG.set_column(0, w - 1, 1.0)  # 약 0.34
worksheetB.set_column(0, w - 1, 1.0)  # 약 0.34

for i in range(h):
    worksheetR.set_row(i, 9.5)  # 약 0.35
    worksheetG.set_row(i, 9.5)  # 약 0.35
    worksheetB.set_row(i, 9.5)  # 약 0.35

for i in range(w) :
    for k in range(h) :
        hexR = hex(photoR[i][k])
        hexG = hex(photoG[i][k])
        hexB = hex(photoB[i][k])
        hexStr = '#'
        if len(hexR[2:]) < 2:
            hexStrR ='0' +hexR[2:]
        else:
            hexStrR = hexR[2:]

        if len(hexG[2:]) < 2:
            hexStrG = '0' + hexG[2:]
        else:
            hexStrG = hexG[2:]

        if len(hexB[2:]) < 2:
            hexStrB = '0' + hexB[2:]
        else:
            hexStrB = hexB[2:]

        cell_formatR = workbook.add_format()
        cell_formatR.set_bg_color(hexStr + hexStrR + '0000')
        cell_formatG = workbook.add_format()
        cell_formatG.set_bg_color(hexStr + '00' + hexStrG + '00')
        cell_formatB = workbook.add_format()
        cell_formatB.set_bg_color(hexStr + '0000' + hexStrB)
        worksheetR.write(k, i, '', cell_formatR)
        worksheetG.write(k, i, '', cell_formatG)
        worksheetB.write(k, i, '', cell_formatB)


workbook.close()
print('Save. OK~')