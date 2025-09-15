import matplotlib.pyplot as plt
import numpy as np

x = [1, 4, 5, 6, 7]
y = [2, 6, 3, 6, 3]


fig = plt.figure()
line1, = plt.plot(x, y, color='red', linewidth=3, linestyle='-.',
                  marker='o', markerfacecolor='blue',  markeredgecolor='blue')

plt.xlim(1, 8)
plt.ylim(1, 8)

plt.title('Draw a line')
plt.ylabel('y - axis')
plt.xlabel('x - axis')


plt.show()