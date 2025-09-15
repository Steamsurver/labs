import matplotlib.pyplot as plt

languages = ['PHP', 'Python', 'JavaScript', 'C++', 'C#']
percentages = [31.3, 24.8, 12.4, 11.3, 9.4]
colors = ['#E74C3C', '#3498DB', '#F39C12', '#2ECC71', '#9B59B6']
explode = (0.1, 0.05, 0, 0, 0)

plt.figure()
plt.pie(percentages, explode=explode, labels=languages,
        colors=colors, autopct='%1.1f%%',
        startangle=90, shadow=True,
        textprops={'fontsize': 13, 'fontweight': 'bold'})



plt.axis('equal')
plt.tight_layout()
plt.show()