def center_win(window, w, h):
  x_pos = int(window.winfo_screenwidth()/2 - w/2)
  y_pos = int(window.winfo_screenheight()/2 - h/2)
  window.geometry(f'{w}x{h}+{x_pos}+{y_pos}')

