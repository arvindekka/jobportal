import { Recruiter } from "./recruiter";

export class Job{
    constructor(
    public id: number,
	public designation: string,
	public hiringCompanyName : string,
	public minSalaryPerYear : string,
	public maxSalaryPerYear : string,
	public currency : string,
	public jobPostingDate : string,
	public jobStatus : string,
	public jobDescription : string,
	public  recruiter : Recruiter,
    ){}

    

}