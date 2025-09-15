import matplotlib.pyplot as plt
import numpy as np


languages = ['Java', 'Python', 'PHP', 'JavaScript', 'C#', 'C++']
popularity = [15, 10, 5, 8, 6, 7]

min_width = 0.1
max_width = 0.6
widths = min_width + (max_width - min_width) * (np.array(popularity) / max(popularity))
x_pos = np.arange(len(languages))

plt.figure()

for i, (lang, pop, width) in enumerate(zip(languages, popularity, widths)):
    plt.bar(x_pos[i], pop, width=width, alpha=0.7,
            color='blue', edgecolor='black', linewidth=1)

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