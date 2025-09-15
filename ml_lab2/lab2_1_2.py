import matplotlib.pyplot as plt
import numpy as np

x = [10, 20, 30]
y1 = [20, 40, 10]
y2 = [40, 10, 30]


fig = plt.figure()
line1, = plt.plot(x, y1, color='blue', linewidth=3)
line2, = plt.plot(x, y2, color ='red', linewidth=5)

plt.xlim(10, 30)
plt.ylim(10, 40)

plt.title('Draw a line')
plt.ylabel('y - axis')
plt.xlabel('x - axis')
plt.legend([line1, line2], [f'line1 - width - {line1.get_linewidth()}',
    f'line2 - width - {line2.get_linewidth()}'])


plt.show()