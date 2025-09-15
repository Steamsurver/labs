import matplotlib.pyplot as plt
import numpy as np

x1 = np.array([2, 3, 5, 6, 8])
x2=  np.array([3, 4, 6, 7, 9])
y1 = np.array([1, 5, 10, 17, 20])
y2 = np.array([2, 6, 11, 20, 23])

plt.figure()
plt.scatter(x1, y2, s=25, c='blue', edgecolors='blue', marker = 'p')

plt.scatter(x2, y2, s=40, c='red', edgecolors='red')

plt.xlim(0, 10)
plt.ylim(0, 30)
plt.show()