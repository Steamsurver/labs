import matplotlib.pyplot as plt
import numpy as np


languages = ['Java', 'Python', 'PHP', 'JavaScript', 'C#', 'C++']
popularity = [15, 10, 5, 8, 6, 7]
colors = ['red', 'black', 'green', 'blue', 'yellow', 'gray']

plt.figure()

bars = plt.bar(languages, popularity, color=colors, alpha=0.8, edgecolor='black', linewidth=1.2)

plt.title('Popularity of Programming Language\nWorldwide, Oct 2017 compared to a year ago',
          fontsize=16, fontweight='bold', pad=20)
plt.xlabel('Languages', fontsize=14, fontweight='bold', labelpad=15)
plt.ylabel('Popularity', fontsize=14, fontweight='bold', labelpad=15)

plt.grid(True, linestyle='--', color='red')
plt.grid(True, which='minor',linestyle='--', linewidth=0.4, color='gray')
plt.minorticks_on()
plt.ylim(0, 30)
plt.tight_layout()
plt.show()