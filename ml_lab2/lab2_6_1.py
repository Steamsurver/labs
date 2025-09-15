import matplotlib.pyplot as plt
import numpy as np
import seaborn as sns
from sklearn.datasets import load_iris

iris = load_iris()
petal_length = iris.data[:, 2]

plt.figure()

sns.histplot(petal_length, bins=15, kde=True, stat='density',
             color='blue', alpha=0.8, edgecolor='navy', linewidth=0.8)

plt.xlabel('petal_length', fontsize=14, fontweight='bold')

plt.xlim(0, 8)
plt.ylim(0, 0.25)
plt.xticks([0, 2, 4, 6, 8], fontsize=12)
plt.yticks([0.00, 0.05, 0.10, 0.15, 0.20, 0.25], fontsize=12)

plt.tight_layout()
plt.show()