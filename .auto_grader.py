#!/usr/bin/env python3
"""
Auto Grader for Date Validation Assignment
Tests student's main.py implementation against various test cases
Outputs results to CSV for analysis
"""

import csv
import subprocess
import sys
import os
from datetime import datetime

class DateValidationGrader:
    def __init__(self):
        self.test_cases = self._generate_test_cases()
        self.results = []

    def _generate_test_cases(self):
        """Generate comprehensive test cases for date validation"""
        test_cases = [
            # Valid dates
            {"input": "01/01/2024", "expected": "valid", "category": "Valid Basic Date"},
            {"input": "12/31/2023", "expected": "valid", "category": "Valid Basic Date"},
            {"input": "06/15/2022", "expected": "valid", "category": "Valid Basic Date"},
            {"input": "02/28/2023", "expected": "valid", "category": "Valid Non-Leap February"},
            {"input": "02/29/2024", "expected": "valid", "category": "Valid Leap Year"},
            {"input": "02/29/2000", "expected": "valid", "category": "Valid Leap Year (Divisible by 400)"},
            {"input": "02/29/1600", "expected": "valid", "category": "Valid Leap Year (Divisible by 400)"},

            # Invalid months
            {"input": "00/15/2023", "expected": "invalid", "category": "Invalid Month (Too Low)"},
            {"input": "13/15/2023", "expected": "invalid", "category": "Invalid Month (Too High)"},
            {"input": "25/15/2023", "expected": "invalid", "category": "Invalid Month (Too High)"},

            # Invalid days - general
            {"input": "01/00/2023", "expected": "invalid", "category": "Invalid Day (Too Low)"},
            {"input": "01/32/2023", "expected": "invalid", "category": "Invalid Day (Too High)"},
            {"input": "06/31/2023", "expected": "invalid", "category": "Invalid Day (30-day Month)"},
            {"input": "04/31/2023", "expected": "invalid", "category": "Invalid Day (30-day Month)"},
            {"input": "09/31/2023", "expected": "invalid", "category": "Invalid Day (30-day Month)"},
            {"input": "11/31/2023", "expected": "invalid", "category": "Invalid Day (30-day Month)"},

            # February leap year tests
            {"input": "02/29/2023", "expected": "invalid", "category": "Invalid Leap Year (Non-leap)"},
            {"input": "02/29/1900", "expected": "invalid", "category": "Invalid Leap Year (Century Non-leap)"},
            {"input": "02/29/1700", "expected": "invalid", "category": "Invalid Leap Year (Century Non-leap)"},
            {"input": "02/29/1800", "expected": "invalid", "category": "Invalid Leap Year (Century Non-leap)"},
            {"input": "02/30/2024", "expected": "invalid", "category": "Invalid February Day"},

            # Edge cases for leap years
            {"input": "02/29/1644", "expected": "valid", "category": "Valid Leap Year"},
            {"input": "02/29/1645", "expected": "invalid", "category": "Invalid Leap Year (Non-leap)"},

            # Format edge cases
            {"input": "1/1/2023", "expected": "valid", "category": "Valid Single Digit Format"},
            {"input": "12/1/2023", "expected": "valid", "category": "Valid Mixed Format"},

            # Boundary years
            {"input": "02/29/4", "expected": "valid", "category": "Valid Early Year Leap"},
            {"input": "12/31/9999", "expected": "valid", "category": "Valid High Year"},
        ]

        return test_cases

    def run_student_code(self, test_input):
        """Run the student's main.py with given input and capture output"""
        try:
            # Run the student's code with input
            process = subprocess.Popen(
                [sys.executable, 'main.py'],
                stdin=subprocess.PIPE,
                stdout=subprocess.PIPE,
                stderr=subprocess.PIPE,
                text=True,
                cwd=os.path.dirname(os.path.abspath(__file__))
            )

            stdout, stderr = process.communicate(input=test_input + '\n', timeout=5)

            if process.returncode != 0:
                return "ERROR: " + stderr.strip(), False

            return stdout.strip(), True

        except subprocess.TimeoutExpired:
            process.kill()
            return "ERROR: Timeout", False
        except Exception as e:
            return "ERROR: " + str(e), False

    def analyze_output(self, output, expected):
        """Analyze if the output indicates valid or invalid date"""
        output_lower = output.lower()

        # Keywords that suggest valid date
        valid_keywords = ['valid', 'correct', 'good', 'true', 'yes', 'proper']

        # Keywords that suggest invalid date
        invalid_keywords = ['invalid', 'incorrect', 'bad', 'false', 'no', 'wrong', 'error']

        # Check for explicit validity indicators
        has_valid = any(keyword in output_lower for keyword in valid_keywords)
        has_invalid = any(keyword in output_lower for keyword in invalid_keywords)

        if has_valid and not has_invalid:
            return "valid"
        elif has_invalid and not has_valid:
            return "invalid"
        elif has_valid and has_invalid:
            # Both present, check which comes first
            valid_pos = min([output_lower.find(kw) for kw in valid_keywords if kw in output_lower])
            invalid_pos = min([output_lower.find(kw) for kw in invalid_keywords if kw in output_lower])
            return "valid" if valid_pos < invalid_pos else "invalid"
        else:
            # No clear indicators
            return "unclear"

    def run_all_tests(self):
        """Run all test cases and collect results"""
        print("Running auto grader for date validation assignment...")
        print(f"Testing {len(self.test_cases)} test cases...\n")

        for i, test_case in enumerate(self.test_cases, 1):
            print(f"Test {i:2}/{len(self.test_cases)}: {test_case['input']:<12} ({test_case['category']})")

            output, success = self.run_student_code(test_case['input'])

            if success:
                interpreted_result = self.analyze_output(output, test_case['expected'])
                if interpreted_result == test_case['expected']:
                    correct = ""  # Leave blank when might be correct
                elif interpreted_result == "unclear":
                    correct = "MIGHT BE INCORRECT"
                else:
                    correct = "MIGHT BE INCORRECT"
            else:
                interpreted_result = "error"
                correct = "MIGHT BE INCORRECT"

            result = {
                'test_number': i,
                'input': test_case['input'],
                'category': test_case['category'],
                'expected': test_case['expected'],
                'output': output,
                'interpreted': interpreted_result,
                'correct': correct,
                'success': success
            }

            self.results.append(result)

            # Color coding for terminal output
            if correct == "":
                print(f"  ✓ MIGHT BE CORRECT")
            elif correct == "MIGHT BE INCORRECT":
                print(f"  ✗ {correct} (Expected: {test_case['expected']}, Got: {interpreted_result})")
            elif interpreted_result == "error":
                print(f"  ! ERROR ({output})")
            print()

    def generate_summary_report(self):
        """Generate a simple summary report"""
        total_tests = len(self.results)
        might_be_correct = sum(1 for r in self.results if r['correct'] == '')
        might_be_incorrect = sum(1 for r in self.results if r['correct'] == 'MIGHT BE INCORRECT')
        errors = sum(1 for r in self.results if r['interpreted'] == 'error')

        print("\n" + "="*60)
        print("TEST RESULTS SUMMARY")
        print("="*60)
        print(f"Total Tests:          {total_tests}")
        print(f"Might Be Correct:     {might_be_correct} ({might_be_correct/total_tests*100:.1f}%)")
        print(f"Might Be Incorrect:   {might_be_incorrect} ({might_be_incorrect/total_tests*100:.1f}%)")
        print(f"Errors:               {errors} ({errors/total_tests*100:.1f}%)")
        print()

        if errors > 0:
            print("ITEMS NEEDING ATTENTION:")
            for result in self.results:
                if result['interpreted'] == 'error':
                    print(f"  {result['input']}: ERROR - {result['output']}")
            print()

        # Category breakdown
        categories = {}
        for result in self.results:
            cat = result['category']
            if cat not in categories:
                categories[cat] = {'total': 0, 'might_be_correct': 0}
            categories[cat]['total'] += 1
            if result['correct'] == '':
                categories[cat]['might_be_correct'] += 1

        print("RESULTS BY CATEGORY:")
        for category, stats in sorted(categories.items()):
            rate = stats['might_be_correct'] / stats['total'] * 100
            print(f"  {category}: {stats['might_be_correct']}/{stats['total']} might be correct ({rate:.0f}%)")

    def export_to_csv(self, filename="grading_results.csv"):
        """Export results to CSV file"""
        with open(filename, 'w', newline='', encoding='utf-8') as csvfile:
            fieldnames = [
                'test_number', 'input', 'category', 'expected', 'output',
                'interpreted', 'correct', 'grader_interpretation'
            ]

            writer = csv.DictWriter(csvfile, fieldnames=fieldnames)
            writer.writeheader()

            for result in self.results:
                # Clean up the result for CSV export
                csv_result = {k: v for k, v in result.items() if k in fieldnames}
                csv_result['grader_interpretation'] = ""  # Add blank field for manual grading
                writer.writerow(csv_result)

        print(f"Detailed results exported to {filename}")

def main():
    """Main function to run the auto grader"""
    # Check if main.py exists
    if not os.path.exists('main.py'):
        print("ERROR: main.py not found in current directory")
        print("Please ensure the student's main.py file is present")
        return

    # Create and run grader
    grader = DateValidationGrader()
    grader.run_all_tests()
    grader.generate_summary_report()

    # Export results
    timestamp = datetime.now().strftime("%Y%m%d_%H%M%S")
    grader.export_to_csv(f"grading_results_{timestamp}.csv")

    print(f"\nGrading complete! Check the CSV file for detailed results.")

if __name__ == "__main__":
    main()
