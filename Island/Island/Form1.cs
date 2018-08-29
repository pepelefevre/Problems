using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Data;
using System.Drawing;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Windows.Forms;

namespace Island
{
    public partial class IslandForm : Form
    {
        public IslandForm()
        {
            InitializeComponent();
            
        }

        private void Form1_Load(object sender, EventArgs e)
        {

        }

        private void goButton_Click(object sender, EventArgs e)
        {
            if (textBox.Text.Length != 0)
            {
                int size;
                if (int.TryParse(textBox.Text, out size))
                {
                    IslandSolver solver = new IslandSolver(size);
                    drawArray(solver.getOcean());
                    answerLabel.Text = "" + solver.solve();
                }
            } 
        }

        private void drawArray(int[,] array)
        {
            // Text for the text field
            string[] text = new string[array.GetLength(0)];

            // Draw each piece of the array
            for (int i = 0; i < array.GetLength(0); ++i)
            {
                string row = "[";
                for (int j = 0; j < array.GetLength(1); ++j)
                {
                    row += " " + array[i, j];
                }
                row += " ]";
                text[i] = row;
            }

            arrayBox.Lines = text;
        }
    }
}
