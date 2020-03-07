export class Reimbursement {
  id: number;
  amount: number;
  // submitted: LocalDate;
  // resolved: LocalDate;
  description: string;
  receipt: any; // will change
  author: number;
  resolver: number;
  status_id: number;
  type_id: number;
}
