import numpy as np
import matplotlib.pyplot as plt

# data = [100, 250, 140, 300, 500]
# plt.plot(data)
# plt.show()

#################################################################################################

# x_data = [10,20,30,40,50]
# y_data = [10000,15000,33000,34000,60000]
# # plt.plot(x_data, y_data)
# # plt.plot(x_data, y_data, color='green', linestyle=':', marker='o')
# plt.plot(x_data, y_data, 'rs')
# plt.show()

#################################################################################################

x_data = ['1st', '2nd', '3rd', '4th', '5th']
x_value = [1,2,3,4,5]
y1_data = [90,28,75,58,78]
y2_data = [80,80,50,40,90]
y3_data = [40,50,90,90,60]

# plt.plot(x_data, y1_data, 'r-o', x_data, y2_data, 'g:x', x_data, y3_data, 'b--p')
plt.bar(x_data, y1_data)

plt.show()