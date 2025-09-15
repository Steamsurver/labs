import numpy as np
import matplotlib.pyplot as plt

x = np.linspace(-4, 5, 200)
y = x**2 - x - 6

plt.figure()
plt.plot(x, y, label=r'$y = x^2 - x - 6$')
plt.axhline(0, color='black', lw=0.8)
plt.axvline(0, color='black', lw=0.8)

roots = [-2, 3]
for root in roots:
    plt.plot(root, 0, 'ro')  # красные точки в корнях
    plt.text(root, 1, f'x={root}', color='red', fontsize=12, ha='center')


plt.title('График функции $y = x^2 - x - 6$ с корнями уравнения')
plt.xlabel('x')
plt.ylabel('y')
plt.grid(True)
plt.legend()
plt.show()