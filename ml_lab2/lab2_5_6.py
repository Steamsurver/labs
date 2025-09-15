import matplotlib.pyplot as plt
import numpy as np


groups = ['G1', 'G2', 'G3', 'G4', 'G5']
men_scores = [85, 70, 90, 65, 80]
women_scores = [75, 85, 65, 90, 70]

x = np.arange(len(groups))
width = 0.35

plt.figure()

bars1 = plt.bar(x - width/2, men_scores, width, label='Men',
                color='green', alpha=0.8, edgecolor='black', linewidth=1.2)
bars2 = plt.bar(x + width/2, women_scores, width, label='Women',
                color='red', alpha=0.8, edgecolor='black', linewidth=1.2)

plt.title('Scores by person', fontsize=16, fontweight='bold', pad=20)
plt.xlabel('Person', fontsize=14, fontweight='bold', labelpad=15)
plt.ylabel('Scores', fontsize=14, fontweight='bold', labelpad=15)
plt.xticks(x, groups, fontsize=12)
plt.yticks(fontsize=12)

plt.legend(loc='upper right', fontsize=12, framealpha=0.9)


plt.tight_layout()
plt.show()