import matplotlib.pyplot as plt
import numpy as np


x = np.linspace(0, 100, 100)
y_linear = 200 - 2 * x
y_curved = 10000 - 100 * x + 0.5 * x**2

fig, (ax1, ax2) = plt.subplots(2, 1)


ax1.plot(x, y_linear, linewidth=2, color='blue')
ax1.set_xlim(0, 100)
ax1.set_ylim(0, 200)
ax1.set_xlabel('x')
ax1.set_ylabel('y')


ax2.plot(x, y_curved, linewidth=2, linestyle='--',color='red')
ax2.set_xlim(0, 100)
ax2.set_ylim(0, 10000)
ax2.set_xlabel('x')
ax2.set_ylabel('y')

plt.tight_layout()
plt.show()