import csv
import math
from collections import defaultdict

# Constants
THRESHOLD_RATIO = 2.5
TARGET_REGIONS = ['deu6', 'che2', 'wa1', 'va7']
NAMESPACE_FILE = '/Users/achelsau/Documents/workspace/namespace_overview.csv'
PROGRAM_FILE = '/Users/achelsau/Documents/workspace/validator_public_program.csv'

def calculate_required_namespaces(programs):
    return math.ceil(programs / THRESHOLD_RATIO)

def main():
    # 1. Load Baseline Data
    region_status = {}
    print("Loading Baseline Data...")
    with open(NAMESPACE_FILE, 'r', encoding='utf-8-sig') as f:
        # Read lines manually to strip whitespace from headers
        lines = f.readlines()
        header = [h.strip() for h in lines[0].split(';')]
        
        reader = csv.DictReader(lines[1:], fieldnames=header, delimiter=';')
        
        for row in reader:
            if not row: continue
            region = row['region']
            if region in TARGET_REGIONS:
                programs = int(row['# of Programs (BOARDING + BOARDED)'])
                namespaces = int(row['# of Enabled Namespaces'])
                region_status[region] = {
                    'current_programs': programs,
                    'current_namespaces': namespaces,
                    'initial_programs': programs,
                    'initial_namespaces': namespaces
                }
    
    # 2. Calculate Immediate Deficits
    immediate_adds = {}
    print("\nCalculating Immediate Deficits (Jan 1):")
    for region, data in region_status.items():
        req_ns = calculate_required_namespaces(data['current_programs'])
        current_ns = data['current_namespaces']
        deficit = max(0, req_ns - current_ns)
        immediate_adds[region] = deficit
        
        # Update state
        region_status[region]['current_namespaces'] += deficit
        
        print(f"  {region}: Programs={data['current_programs']}, Current NS={current_ns}, Required={req_ns}, Deficit={deficit}")

    # 3. Load 2025 Growth Patterns (to project for 2026)
    print("\nLoading 2025 Growth Patterns...")
    monthly_growth = defaultdict(lambda: defaultdict(int))
    
    with open(PROGRAM_FILE, 'r', encoding='utf-8-sig') as f:
        reader = csv.reader(f, delimiter=';')
        try:
            next(reader) # Skip header
        except StopIteration:
            pass
            
        for row in reader:
            if not row: continue
            state = row[3]
            if state in ['BOARDED', 'BOARDING']:
                created_at = row[2]
                region = row[4].strip()
                
                if region in TARGET_REGIONS:
                    try:
                        # format: 2025-04-01 00:30:39.060000
                        date_part = created_at.split(' ')[0]
                        year, month, day = date_part.split('-')
                        if year == '2025':
                            monthly_growth[region][int(month)] += 1
                    except ValueError:
                        pass

    # 4. Simulate 2026
    print("\nSimulating 2026 Monthly Requirements...")
    monthly_additions = defaultdict(lambda: defaultdict(int))
    total_2026_adds = defaultdict(int)

    for region in TARGET_REGIONS:
        # Add immediate adds to total
        total_2026_adds[region] = immediate_adds[region]
        
        print(f"\n--- {region} Simulation ---")
        current_programs = region_status[region]['current_programs']
        current_ns = region_status[region]['current_namespaces']
        
        for month in range(1, 13):
            new_programs = monthly_growth[region][month]
            current_programs += new_programs
            
            req_ns = calculate_required_namespaces(current_programs)
            needed = max(0, req_ns - current_ns)
            
            if needed > 0:
                monthly_additions[region][month] = needed
                total_2026_adds[region] += needed
                current_ns += needed
                print(f"  Month {month}: +{new_programs} Programs (Total {current_programs}). Need +{needed} NS (Total {current_ns})")
            else:
                 pass
            
            # Update tracking for next month
            region_status[region]['current_namespaces'] = current_ns

    # 5. Final Report
    print("\n" + "="*80)
    print("FINAL REPORT: 2026 NAMESPACE ADDITIONS")
    print("="*80)
    print(f"{'Region':<8} | {'Immediate (Jan 1)':<20} | {'Total 2026 Adds':<15} | {'Timeline'}")
    print("-" * 80)
    
    for region in TARGET_REGIONS:
        timeline = []
        # Immediate
        if immediate_adds[region] > 0:
            timeline.append(f"Jan 1: +{immediate_adds[region]}")
        
        # Monthly
        sorted_months = sorted(monthly_additions[region].keys())
        for m in sorted_months:
            count = monthly_additions[region][m]
            month_name = datetime_month_name(m)
            timeline.append(f"{month_name}: +{count}")
            
        timeline_str = ", ".join(timeline)
        if not timeline_str:
            timeline_str = "None"
            
        print(f"{region:<8} | {immediate_adds[region]:<20} | {total_2026_adds[region]:<15} | {timeline_str}")

def datetime_month_name(month_num):
    months = ["", "Jan", "Feb", "Mar", "Apr", "May", "Jun", "Jul", "Aug", "Sep", "Oct", "Nov", "Dec"]
    return months[month_num]

if __name__ == "__main__":
    main()
